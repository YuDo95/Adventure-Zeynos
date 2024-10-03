package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Instruktører;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InstruktørerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Instruktører> findAll() {
        String sql = "SELECT * FROM Instruktører";
        return jdbcTemplate.query(sql, this::mapRowToInstruktør);
    }

    public Instruktører findById(int id) {
        String sql = "SELECT * FROM Instruktører WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToInstruktør);
    }

    public void save(Instruktører instruktører) {
        String sql = "INSERT INTO Instruktører (navn) VALUES (?)";
        jdbcTemplate.update(sql, instruktører.getNavn());
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM Instruktører WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private Instruktører mapRowToInstruktør(ResultSet rs, int rowNum) throws SQLException {
        Instruktører instruktør = new Instruktører();
        instruktør.setId(rs.getInt("id"));
        instruktør.setNavn(rs.getString("navn"));
        return instruktør;
    }
}