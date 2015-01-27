package models

import javax.persistence._
import dao.Dao
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
  def authenticate(username: String, password: String): User =
    find.where().eq("username", username).eq("password", password).findUnique()
}