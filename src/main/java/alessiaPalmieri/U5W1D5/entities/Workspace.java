package alessiaPalmieri.U5W1D5.entities;

import alessiaPalmieri.U5W1D5.Enum.WorkspaceType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "workspace")
public class Workspace {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private WorkspaceType type;

    private int capacity;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "workspace")
    private List<Reservation> reservations;

    public Workspace(String description, WorkspaceType type, int capacity, Building building) {
        this.description = description;
        this.type = type;
        this.capacity = capacity;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Workspace{" +
                "description='" + description + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                '}';
    }
}
