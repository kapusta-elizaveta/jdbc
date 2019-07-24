package com.gym.repository.impl;

import com.gym.entity.Schedule;
import com.gym.jdbc.DataBaseConnection;
import com.gym.repository.ScheduleRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private static final String SQL_CREATE =  "INSERT INTO Shedule start_time, end_time, office_id, room_id) VALUES (?, ?, ?, ?)";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM Schedule WHERE Id = ?";

    private static final String SQL_FIND_BY_OFFICE_ID = "SELECT * FROM Schedule WHERE Office_Id = ?";

    private static final String SQL_FIND_BY_ROOM_ID = "SELECT * FROM Schedule WHERE Room_Id = ?";

    private static final String SQL_DELETE_BY_ID = "DELETE FROM Schedule WHERE Id = ?";

    private static final String SQL_GET_ALL = "SELECT * FROM Schedule";

    private DataBaseConnection dataBaseConnection;

    private Connection connection;

    private Statement statement;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    private List<Schedule> scheduleList;

    private Schedule schedule;

    @Override
    public void save(Schedule schedule) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE);
            preparedStatement.setString(1, schedule.getStartTime());
            preparedStatement.setString(2, schedule.getEndTime());
            preparedStatement.setInt(3, schedule.getOfficeId());
            preparedStatement.setInt(4,schedule.getRoomId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Schedule> findByOfficeId(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_OFFICE_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            scheduleList = schedulesInit(resultSet);

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

        return scheduleList;
    }

    @Override
    public List<Schedule> findByRoomId(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ROOM_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            scheduleList = schedulesInit(resultSet);

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
            return scheduleList;
    }

    @Override
    public List<Schedule> findAll() {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL);
            scheduleList = schedulesInit(resultSet);
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

        return scheduleList;
    }

    @Override
    public Schedule findById(Integer id) {
        dataBaseConnection = new DataBaseConnection();
        connection = dataBaseConnection.getConnectin();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            schedule = schedules(resultSet);
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
        return schedule;
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

    Schedule schedules(ResultSet resultSet) throws SQLException {
        Schedule schedule = new Schedule();
        while (resultSet.next()){
            schedule.setId(resultSet.getInt("Id"));
            schedule.setStartTime(resultSet.getString("Start_Time"));
            schedule.setEndTime(resultSet.getString("End_Time"));
            schedule.setOfficeId(resultSet.getInt("Office_Id"));
            schedule.setRoomId(resultSet.getInt("Room_Id"));
        }
        return schedule;
    }

    List<Schedule> schedulesInit(ResultSet resultSet) throws SQLException {
        List<Schedule> list = new ArrayList<>();
        while (resultSet.next()){
            Schedule schedule = new Schedule();
            schedule.setId(resultSet.getInt("Id"));
            schedule.setStartTime(resultSet.getString("Start_Time"));
            schedule.setEndTime(resultSet.getString("End_Time"));
            schedule.setOfficeId(resultSet.getInt("Office_Id"));
            schedule.setRoomId(resultSet.getInt("Room_Id"));
            list.add(schedule);
        }
        return list;
    }
}
