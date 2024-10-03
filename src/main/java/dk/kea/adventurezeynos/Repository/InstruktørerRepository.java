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

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InstruktørerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to find all Instruktører
    public List<Instruktører> findAll() {
        String sql = "SELECT * FROM Instruktører";
        return jdbcTemplate.query(sql, this::mapRowToInstruktør);
    }

    // Method to find Instruktør by ID
    public Instruktører findById(int id) {
        String sql = "SELECT * FROM Instruktører WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToInstruktør);
    }

    // Method to save a new Instruktør
    public Instruktører save(Instruktører instruktør) {
        String sql = "INSERT INTO Instruktører (navn) VALUES (?)";
        jdbcTemplate.update(sql, instruktør.getNavn());
        return instruktør;
    }

    // Method to delete Instruktør by ID
    public void deleteById(int id) {
        String sql = "DELETE FROM Instruktører WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Mapping the ResultSet to Instruktører object
    private Instruktører mapRowToInstruktør(ResultSet rs, int rowNum) throws SQLException {
        Instruktører instruktør = new Instruktører();
        instruktør.setId(rs.getInt("id"));
        instruktør.setNavn(rs.getString("navn"));
        return instruktør;
    }
}

