package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Model.Instruktører;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AktiviteterRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AktiviteterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to find all Aktiviteter
    public List<Aktiviteter> findAll() {
        String sql = "SELECT * FROM Aktiviteter";
        return jdbcTemplate.query(sql, this::mapRowToAktiviteter);
    }

    // Method to find Aktiviteter by ID
    public Aktiviteter findById(int id) {
        String sql = "SELECT * FROM Aktiviteter WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToAktiviteter);
    }

    // Method to save a new Aktivitet
    public Aktiviteter save(Aktiviteter aktiviteter) {
        String sql = "INSERT INTO Aktiviteter (navn, instruktør_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, aktiviteter.getNavn(), aktiviteter.getInstruktør().getId());
        return aktiviteter;
    }

    // Method to delete Aktivitet by ID
    public void deleteById(int id) {
        String sql = "DELETE FROM Aktiviteter WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Mapping the ResultSet to Aktiviteter object
    private Aktiviteter mapRowToAktiviteter(ResultSet rs, int rowNum) throws SQLException {
        Aktiviteter aktivitet = new Aktiviteter();
        aktivitet.setId(rs.getInt("id"));
        aktivitet.setNavn(rs.getString("navn"));

        // Assuming Instruktører class has a constructor that accepts an id and name
        Instruktører instruktør = new Instruktører();
        instruktør.setId(rs.getInt("instruktør_id")); // You might need to fetch the name based on id if needed
        aktivitet.setInstruktør(instruktør);

        return aktivitet;
    }
}
