package alessiaPalmieri.U5W1D5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;

    public Reservation(LocalDate date, User user, Workspace workspace) {
        this.date = date;
        this.user = user;
        this.workspace = workspace;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "date=" + date +
                ", user=" + user +
                ", workspace=" + workspace +
                '}';
    }
}
