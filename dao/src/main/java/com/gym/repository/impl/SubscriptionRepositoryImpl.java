package com.gym.repository.impl;

import com.gym.entity.Subscription;
import com.gym.jdbc.DataBaseConnection;
import com.gym.repository.SubscriptionRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    private static final String SQL_CREATE =  "INSERT INTO Subscription (number_visits, price) VALUES ( ?, ?)";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM Subscription WHERE Id = ?";

    private static final String SQL_FIND_CHEAPER_SUBSCRIPTION = "SELECT * FROM Subscription WHERE PRICE <= ?";

    private static final String SQL_FIND_ALL = "SELECT * FROM Subscription";

    private static final String SQL_DELETE_BY_ID = "DELETE FROM Sale WHERE Id = ?";

    private DataBaseConnection dataBaseConnection;

    private Connection connection;

    private Statement statement;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    List<Subscription> subscriptionList;

    Subscription subscription;

    @Override
    public void save(Subscription subscription) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE);
            preparedStatement.setInt(1,subscription.getNumberVisit());
            preparedStatement.setDouble(2,subscription.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Subscription> findAll() {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_FIND_ALL);
            subscriptionList = subscriptionsInit(resultSet);

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
        return subscriptionList;
    }

    @Override
    public List<Subscription> findCheaperSubscription(double price) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_CHEAPER_SUBSCRIPTION);
            preparedStatement.setDouble(1,price);
            resultSet = preparedStatement.executeQuery();
            subscriptionList = subscriptionsInit(resultSet);
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

        return subscriptionList;
    }

    @Override
    public Subscription findById(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            subscription = subscriptions(resultSet);
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
        return subscription;
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

    Subscription subscriptions(ResultSet resultSet) throws SQLException {
        Subscription subscription = new Subscription();
        while (resultSet.next()){
            subscription.setId(resultSet.getInt("Id"));
            subscription.setNumberVisit(resultSet.getInt("Number_Visits"));
            subscription.setPrice(resultSet.getDouble("Price"));
        }
        return subscription;
    }

    List<Subscription> subscriptionsInit(ResultSet resultSet) throws SQLException {
        List<Subscription> list = new ArrayList<>();
        if (resultSet.next()){
            Subscription subscription = new Subscription();
            subscription.setId(resultSet.getInt("Id"));
            subscription.setNumberVisit(resultSet.getInt("Number_Visits"));
            subscription.setPrice(resultSet.getDouble("Price"));
            list.add(subscription);
        }
        return list;
    }
}
