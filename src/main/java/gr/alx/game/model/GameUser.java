package gr.alx.game.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;

@Entity
public class GameUser implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id = null;

   @Column
   private String email;

   @Version
   @Column(name = "version")
   private int version = 0;

   @Column
   private String username;

   public GameUser()
   {
   }

   public GameUser(String username)
   {
      this.username = username;
   }

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {

      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   public String getUsername()
   {
      return this.username;
   }

   public void setUsername(final String username)
   {
      this.username = username;
   }

   public String getEmail()
   {
      return this.email;
   }

   public void setEmail(final String email)
   {
      this.email = email;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameUser user = (GameUser) o;

        if (version != user.version) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (!id.equals(user.id)) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + version;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameUser{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", version=").append(version);
        sb.append(", username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }
}