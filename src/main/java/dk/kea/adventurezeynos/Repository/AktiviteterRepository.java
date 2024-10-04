package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Model.Instruktører;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AktiviteterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Aktiviteter> findAll() {
        String sql = "SELECT a.*, i.id as instruktør_id, i.navn as instruktør_navn FROM aktiviteter a " +
                "JOIN instruktører i ON a.instruktør_id = i.id";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Aktiviteter aktivitet = new Aktiviteter();
            aktivitet.setId(rs.getInt("id"));
            aktivitet.setNavn(rs.getString("navn"));
            Instruktører instruktør = new Instruktører();
            instruktør.setId(rs.getInt("instruktør_id"));
            instruktør.setNavn(rs.getString("instruktør_navn"));
            aktivitet.setInstruktør(instruktør);
            return aktivitet;
        });
    }

    public void save(Aktiviteter aktivitet) {
        String sql = "INSERT INTO aktiviteter (navn, instruktør_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, aktivitet.getNavn(), aktivitet.getInstruktør().getId());
    }

    public Aktiviteter findById(int id) {
        String sql = "SELECT a.*, i.id as instruktør_id, i.navn as instruktør_navn FROM aktiviteter a " +
                "JOIN instruktører i ON a.instruktør_id = i.id WHERE a.id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Aktiviteter aktivitet = new Aktiviteter();
            aktivitet.setId(rs.getInt("id"));
            aktivitet.setNavn(rs.getString("navn"));
            Instruktører instruktør = new Instruktører();
            instruktør.setId(rs.getInt("instruktør_id"));
            instruktør.setNavn(rs.getString("instruktør_navn"));
            aktivitet.setInstruktør(instruktør);
            return aktivitet;
        });
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM aktiviteter WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}