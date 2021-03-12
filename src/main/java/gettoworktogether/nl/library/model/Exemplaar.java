package gettoworktogether.nl.library.model;

import javax.persistence.*;

@Entity
public class Exemplaar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String nr;

    @Column
    String status;

    @ManyToOne
    Book book;
}
