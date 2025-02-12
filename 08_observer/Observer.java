public interface Observer {
  
  /** 
  * New information is available to observe.
  * @param newData Data Structure holding information.
  */
  void update(Object newData);
  
}
