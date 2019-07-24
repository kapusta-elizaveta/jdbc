package com.gym.repository.impl;

import com.gym.entity.Client;
import com.gym.jdbc.DataBaseConnection;
import com.gym.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private static final String SQL_CREATE =  "INSERT INTO Client (email, login, name, password, phone_number) VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_GET_ALL = "SELECT * FROM Client";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM Client WHERE Id = ?";

    private static final String SQL_FIND_BY_NAME = "SELECT * FROM Client WHERE Name = ?";

    private static final String SQL_FIND_BY_LOGIN = "SELECT * FROM Client WHERE Login = ?";

    private static final String SQL_DELETE_BY_ID = "DELETE FROM Client WHERE id= ?";

    private DataBaseConnection dataBaseConnection = null;

    private Connection connection = null;

    private Statement statement = null;

    private ResultSet resultSet = null;

    private List<Client> clientList = null;

    private PreparedStatement preparedStatement = null;

    private Client client;

    @Override
    public void save(Client client) {
        dataBaseConnection=new DataBaseConnection();
        connection=dataBaseConnection.getConnectin();
        try{preparedStatement=connection.prepareStatement(SQL_CREATE);
            preparedStatement.setString(1,client.getEmail());
            preparedStatement.setString(2,client.getLogin());
            preparedStatement.setString(3,client.getName());
            preparedStatement.setString(4,client.getPassword());
            preparedStatement.setString(5,client.getPhoneNumber());
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
    public List<Client> findAll() {
        dataBaseConnection = new DataBaseConnection();
        try {
            connection = dataBaseConnection.getConnectin();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL);
            clientList = clientInit(resultSet);
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
        return clientList;
    }

    public Client findById(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            client = clients(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;

    }
    @Override
    public List<Client> findByName(String name) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_NAME);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            clientList = clientInit(resultSet);
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
        return clientList;
    }

    @Override
    public Client findByLogin(String login) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            client = clients(resultSet);

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
        return client;
    }

    @Override
    public void deleteById(Integer id) {
         dataBaseConnection = new DataBaseConnection();
         connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Client clients(ResultSet resultSet) throws SQLException {
        Client client = new Client();
      while (resultSet.next()){
          client.setId(resultSet.getInt("Id"));
          client.setEmail(resultSet.getString("Email"));
          client.setLogin(resultSet.getString("Login"));
          client.setName(resultSet.getString("Name"));
          client.setPhoneNumber(resultSet.getString("Phone_Number"));
          client.setOfficeId(resultSet.getInt("Office_Id"));
      }
      return client;
    }

    private List<Client> clientInit(ResultSet resultSet) throws SQLException {

        List<Client> list = new ArrayList();
        while (resultSet.next()){
            Client client = new Client();
            client.setId(resultSet.getInt("Id"));
            client.setEmail(resultSet.getString("Email"));
            client.setLogin(resultSet.getString("Login"));
            client.setName(resultSet.getString("Name"));
            client.setPhoneNumber(resultSet.getString("Phone_Number"));
            client.setOfficeId(resultSet.getInt("Office_Id"));
            list.add(client);
        }
         return list;
    }
}
