package com.gym.repository.impl;

import com.gym.entity.Coach;
import com.gym.jdbc.DataBaseConnection;
import com.gym.repository.CoachRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CoachRepositoryImpl implements CoachRepository {

    private static final String SQL_CREATE =  "INSERT INTO Coach (email, name, phone_number) VALUES ( ?, ?, ?)";

    private static final String SQL_GET_ALL = "SELECT * FROM Coach";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM coach WHERE id = ?";

    private static final String SQL_FIND_BY_NAME = "SELECT * FROM Coach WHERE Name = ?";

    private static final String SQL_DELETE_BY_ID = "DELETE FROM Coach WHERE id= ?";

    private DataBaseConnection dataBaseConnection = null;

    private Connection connection = null;

    private Statement statement = null;

    private ResultSet resultSet = null;

    private List<Coach> coachList = null;

    private PreparedStatement preparedStatement = null;

    private Coach coach;

    @Override
    public void save(Coach coach) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE);
            preparedStatement.setString(1, coach.getEmail());
            preparedStatement.setString(2,coach.getName());
            preparedStatement.setString(3,coach.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Coach> findAll() {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL);
            coachList = coachesInit(resultSet);

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
        return coachList;
    }

    @Override
    public List<Coach> findByName(String name) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_NAME);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            coachList = coachesInit(resultSet);
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
        return coachList;
    }

    @Override
    public Coach findById(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            coach = coachs(resultSet);
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
        return coach;
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

    Coach coachs(ResultSet resultSet) throws SQLException {
        Coach coach = new Coach();
        while (resultSet.next()){
            coach.setId(resultSet.getInt("Id"));
            coach.setEmail(resultSet.getString("Email"));
            coach.setName(resultSet.getString("Name"));
            coach.setPhoneNumber(resultSet.getString("Phone_Number"));

        }
        return coach;
    }

    List<Coach> coachesInit(ResultSet resultSet) throws SQLException {
        List<Coach> list = new ArrayList<>();
        while (resultSet.next()){
            Coach coach = new Coach();
            coach.setId(resultSet.getInt("Id"));
            coach.setEmail(resultSet.getString("Email"));
            coach.setName(resultSet.getString("Name"));
            coach.setPhoneNumber(resultSet.getString("Phone_Number"));
            list.add(coach);
        }
        return list;
    }
}
