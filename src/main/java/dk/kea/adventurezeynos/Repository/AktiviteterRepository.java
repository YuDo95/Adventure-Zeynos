package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AktiviteterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Aktiviteter> findAll() {
        String sql = "SELECT * FROM aktiviteter";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Aktiviteter aktivitet = new Aktiviteter();
            aktivitet.setId(rs.getInt("id"));
            aktivitet.setNavn(rs.getString("navn"));
            aktivitet.setId(rs.getInt("instruktør_id"));
            return aktivitet;
        });
    }

    public void save(Aktiviteter aktivitet) {
        String sql = "INSERT INTO aktiviteter (navn, instruktør_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, aktivitet.getNavn(), aktivitet.getId());
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM aktiviteter WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Aktiviteter findById(int id) {
        String sql = "SELECT * FROM aktiviteter WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Aktiviteter aktivitet = new Aktiviteter();
            aktivitet.setId(rs.getInt("id"));
            aktivitet.setNavn(rs.getString("navn"));
            aktivitet.setId(rs.getInt("instruktør_id"));
            return aktivitet;
        });
    }

}
