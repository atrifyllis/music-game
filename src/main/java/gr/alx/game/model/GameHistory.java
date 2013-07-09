package gr.alx.game.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gr.alx.game.model.GameUser;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class GameHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id = null;
    @Version
    @Column(name = "version")
    private int version = 0;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne
    private GameUser userid;

    @Column
    private String title;

    @Column
    private String status;

    @Column
    private String lyrics;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public GameUser getUserid() {
        return this.userid;
    }

    public void setUserid(final GameUser userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getLyrics() {
        return this.lyrics;
    }

    public void setLyrics(final String lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameHistory that = (GameHistory) o;

        if (version != that.version) return false;
        if (!date.equals(that.date)) return false;
        if (!id.equals(that.id)) return false;
        if (lyrics != null ? !lyrics.equals(that.lyrics) : that.lyrics != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (!userid.equals(that.userid)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + version;
        result = 31 * result + date.hashCode();
        result = 31 * result + userid.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (lyrics != null ? lyrics.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameHistory{");
        sb.append("id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", date=").append(date);
        sb.append(", userid=").append(userid);
        sb.append(", title='").append(title).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", lyrics='").append(lyrics).append('\'');
        sb.append('}');
        return sb.toString();
    }
}