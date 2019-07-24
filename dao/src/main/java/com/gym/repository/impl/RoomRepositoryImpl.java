package com.gym.repository.impl;

import com.gym.entity.Room;
import com.gym.jdbc.DataBaseConnection;
import com.gym.repository.RoomRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

    private static final String SQL_CREATE =  "INSERT INTO Room ( name) VALUES ( ?)";

    private static final String SQL_GET_ALL = "SELECT * FROM Room";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM Room WHERE Id = ?";

    private static final String SQL_FIND_BY_NAME = "SELECT * FROM Room WHERE Name = ?";

    private static final String SQL_DELETE_BY_ID = "DELETE FROM Room WHERE Id = ?";

    private DataBaseConnection dataBaseConnection;

    private Connection connection;

    private Statement statement;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    private List<Room> roomList;

    private Room room;

    @Override
    public void save(Room room) {
        dataBaseConnection  = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE);
            preparedStatement.setString(1,room.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Room> findAll() {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL);
            roomList = roomsInit(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return roomList;
    }

    @Override
    public Room findByName(String name) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_NAME);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            room = rooms(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return room;
    }

    @Override
    public Room findById(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            room = rooms(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return room;
    }

    @Override
    public void deleteById(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    Room rooms(ResultSet resultSet) throws SQLException {
        Room room = new Room();
        while (resultSet.next()){
            room.setId(resultSet.getInt("Id"));
            room.setName(resultSet.getString("Name"));
        }
        return room;
    }

    List<Room> roomsInit(ResultSet resultSet) throws SQLException {
        List<Room> list = new ArrayList<>();
        if (resultSet.next()){
            Room room = new Room();
            room.setId(resultSet.getInt("Id"));
            room.setName(resultSet.getString("Name"));
            list.add(room);
        }
        return list;
    }
}
