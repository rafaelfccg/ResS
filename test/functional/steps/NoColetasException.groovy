package steps

class NoColetasException extends RuntimeException {

  Object invalidObject 

  NoColetasException(String msg, Object invalidObject){

    super(msg)

    this.invalidObject = invalidObject

  }

}
