package dao

import com.avaje.ebean._  
  
/** 
 * Dao for a given Entity bean type. 
 */  
abstract class Dao[T](cls:Class[T]) {  
  /** 
   * Find by Id. 
   */
  def find(id:Any):T = {  
    return Ebean.find(cls, id)  
  }  
    
  /** 
   * Find with expressions and joins etc. 
   */  
  def find():Query[T] = {  
    return Ebean.find(cls)  
  }  
  
  /** 
   * Return a reference. 
   */  
  def ref(id:Any):T = {  
    return Ebean.getReference(cls, id)  
  }  
    
    
  /** 
   * Save (insert or update). 
   */  
  def save(o:Any):Unit = {  
    Ebean.save(o);  
  }  
    
  /** 
   * Delete. 
   */  
  def delete(o:Any):Unit = {  
    Ebean.delete(o);  
  }  
}  