package com.gym.repository.impl;

import com.gym.entity.Office;
import com.gym.jdbc.DataBaseConnection;
import com.gym.repository.OfficeRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OfficeRepositoryImpl implements OfficeRepository {

    private static final String SQL_CREATE =  "INSERT INTO Office ( name, coach_id, room_id) VALUES (?, ?, ?)";

    private static final String SQL_GET_ALL = "SELECT * FROM Office";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM Office WHERE Id = ?";

    private static final String SQL_FIND_BY_NAME = "SELECT * FROM office WHERE name = ?";

    private static final String SQL_DELETE_BY_ID = "DELETE FROM Office WHERE Id = ?";

    private static final String SQL_FIND_BY_COACH_ID = "SELECT * FROM office WHERE coach_id = ?";

    private DataBaseConnection dataBaseConnection;

    private Connection connection;

    private PreparedStatement preparedStatement;

    private Statement statement;

    private ResultSet resultSet;

    private List<Office> officeList;

    private Office office;

    @Override
    public void save(Office office) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE);
            preparedStatement.setString(1, office.getName());
            preparedStatement.setInt(2, office.getCoachId());
            preparedStatement.setInt(3,office.getRoomId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Office> findAll() {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL);
            officeList = officesInit(resultSet);
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
        return officeList;
    }

    @Override
    public Office findById(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            office = offices(resultSet);
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
        return office;
    }

    @Override
    public Office findByName(String name) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_NAME);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            office = offices(resultSet);
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
        return office;
    }

    @Override
    public List<Office> findByCoachId(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_COACH_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            officeList = officesInit(resultSet);
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
        return officeList;
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

    }

    Office offices(ResultSet resultSet) throws SQLException {
        Office office = new Office();
        while (resultSet.next()) {
            office.setId(resultSet.getInt("Id"));
            office.setName(resultSet.getString("Name"));
            office.setCoachId(resultSet.getInt("Coach_Id"));
            office.setRoomId(resultSet.getInt("Room_Id"));
        }
        return office;
    }

    List<Office> officesInit(ResultSet resultSet) throws SQLException {
        List<Office> list = new ArrayList<>();
        while (resultSet.next()){
        Office office = new Office();
        office.setId(resultSet.getInt("Id"));
        office.setName(resultSet.getString("Name"));
        office.setCoachId(resultSet.getInt("Coach_Id"));
        office.setRoomId(resultSet.getInt("Room_Id"));
        list.add(office);
    }
         return list;
    }
}
