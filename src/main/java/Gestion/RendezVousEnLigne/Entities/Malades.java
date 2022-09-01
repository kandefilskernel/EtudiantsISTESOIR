package Gestion.RendezVousEnLigne.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patientsmalades")
public class Malades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nom_Malade")
    private  String nom;

    @Column(name = "Date_Naissance")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datenaissance;

    @Column(name = "Etat_Malade")
    private boolean malade;

    @Column(name = "Score")
    private int score;
}
