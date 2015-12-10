package models

import javax.persistence._
import dao.Dao
import sun.security.util.Password
import _root_.scala.beans.BeanProperty
import scala.beans.BeanProperty

@Entity
class User {
  @Id
  var id: Int = 0

  @Column
  @BeanProperty
  var username: String = null

  @Column
  @BeanProperty
  var password: String = null

  @Column
  @BeanProperty
  var name: String = null
}

object User extends Dao(classOf[User]) {
  def apply(username: String, password: String, name: String): User = {
    val user = new User()
    user.setUsername(username)
    user.setPassword(password)
    user.setName(name)
    user
  }

  def unapply(user: User): Option[(String, String, String)] = Some((user.getUsername, user.getPassword, user.getName))

  def authenticate(username: String, password: String): User =
    find.where().eq("username", username).eq("password", password).findUnique()
}