package ec.sevolutivo.sevuelos.sevuelos.domain;

import ec.sevolutivo.sevuelos.sevuelos.domain.enumeration.RequestStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Request.
 */
@Entity
@Table(name = "request")
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "passenger", length = 100, nullable = false)
    private String passenger;

    @NotNull
    @Size(max = 100)
    @Column(name = "destination", length = 100, nullable = false)
    private String destination;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RequestStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Request id(Long id) {
        this.id = id;
        return this;
    }

    public String getPassenger() {
        return this.passenger;
    }

    public Request passenger(String passenger) {
        this.passenger = passenger;
        return this;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getDestination() {
        return this.destination;
    }

    public Request destination(String destination) {
        this.destination = destination;
        return this;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public Request status(RequestStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Request)) {
            return false;
        }
        return id != null && id.equals(((Request) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Request{" +
                "id=" + getId() +
                ", passenger='" + getPassenger() + "'" +
                ", destination='" + getDestination() + "'" +
                ", status='" + getStatus() + "'" +
                "}";
    }
}
