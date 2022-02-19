package JavaFX_project.Database;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDaoParameterDescription {

    private final NamedParameterJdbcTemplate jdbc;

    public TableDaoParameterDescription() {
        String url = "jdbc:sqlite:SQLite_voip.db";
        DataSource dataSource = new DriverManagerDataSource(url);
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<TableParameterDescription> getAll() {
        String sql = "SELECT d.Nazwa_parametru, d.Opis_parametru FROM Opis_parametrow d ";
        try {
            return jdbc.query(sql, new RowMapper<TableParameterDescription>() {
                @Override
                public TableParameterDescription mapRow(ResultSet rs, int rownumber) throws SQLException {
                    TableParameterDescription parameterDescription = new TableParameterDescription();
                    parameterDescription.setParameter_name(rs.getString(1));
                    parameterDescription.setParameter_description(rs.getString(2));
                    return parameterDescription;
                }
            });
        } catch (EmptyResultDataAccessException ex) {
            return new ArrayList<>();
        }
    }
}
