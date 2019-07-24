package com.gym.repository.impl;

import com.gym.entity.SaleSubscription;
import com.gym.jdbc.DataBaseConnection;
import com.gym.repository.SaleSubscriptionRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleSubscriptionRepositoryImpl implements SaleSubscriptionRepository {

    private static final String SQL_CREATE =  "INSERT INTO Sale_Subscription (start_date, end_date, client_id, subscriptions_id) VALUES (?, ?, ?, ?)";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM sale_subscription WHERE Id = ?";

    private static final String SQL_FIND_BY_CLIENT_ID = "SELECT * FROM sale_subscription WHERE client_id = ?";

    private static final String SQL_FIND_BY_SUBSCRIPTION_ID = "SELECT * FROM sale_subscription WHERE subscriptions_id = ?";

    private static final String SQL_DELETE_BY_ID = "DELETE FROM sale_subscription WHERE Id = ?";

    private DataBaseConnection dataBaseConnection;

    private Connection connection;

    private Statement statement;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    private List<SaleSubscription> saleSubscriptionList;

    private SaleSubscription saleSubscription;

    @Override
    public void save(SaleSubscription saleSubscription) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE);
            preparedStatement.setString(1,saleSubscription.getStartDate());
            preparedStatement.setString(2,saleSubscription.getEndDate());
            preparedStatement.setInt(3, saleSubscription.getClientId());
            preparedStatement.setInt(4, saleSubscription.getSubscriptionId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SaleSubscription> findByClientId(Integer id) {

        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_CLIENT_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            saleSubscriptionList = saleSubscriptionsInit(resultSet);
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
        return saleSubscriptionList;
    }

    @Override
    public List<SaleSubscription> findBySubscriptionId(Integer id) {

        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_SUBSCRIPTION_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            saleSubscriptionList = saleSubscriptionsInit(resultSet);
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

        return saleSubscriptionList;
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

    @Override
    public SaleSubscription findById(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            saleSubscription = saleSubscriptions(resultSet);
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
        return saleSubscription;
    }

    SaleSubscription saleSubscriptions(ResultSet resultSet) throws SQLException {
        SaleSubscription saleSubscription = new SaleSubscription();
        while (resultSet.next()){
            saleSubscription.setId(resultSet.getInt("Id"));
            saleSubscription.setStartDate(resultSet.getString("Start_Date"));
            saleSubscription.setEndDate(resultSet.getString("End_Date"));
            saleSubscription.setClientId(resultSet.getInt("Client_Id"));
            saleSubscription.setSubscriptionId(resultSet.getInt("Subscriptions_Id"));
        }
        return saleSubscription;
    }

    List<SaleSubscription> saleSubscriptionsInit(ResultSet resultSet) throws SQLException {
        List<SaleSubscription> list = new ArrayList<>();
        while (resultSet.next()){
            SaleSubscription saleSubscription = new SaleSubscription();
            saleSubscription.setId(resultSet.getInt("Id"));
            saleSubscription.setStartDate(resultSet.getString("Start_Date"));
            saleSubscription.setEndDate(resultSet.getString("End_Date"));
            saleSubscription.setClientId(resultSet.getInt("Client_Id"));
            saleSubscription.setSubscriptionId(resultSet.getInt("Subscriptions_Id"));
            list.add(saleSubscription);
        }
        return list;
    }
}
