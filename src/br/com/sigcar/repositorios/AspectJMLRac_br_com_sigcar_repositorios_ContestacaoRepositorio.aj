import br.com.sigcar.repositorios.*;
import org.aspectjml.ajmlrac.runtime.*;
import org.aspectjml.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;
import br.com.sigcar.dominio.Contestacao;
import br.com.sigcar.exceptions.NegocioException;
import java.util.Map;
import java.util.Map.Entry;


privileged aspect AspectJMLRac_br_com_sigcar_repositorios_ContestacaoRepositorio$dbfaeb11_f4ed_4598_9b36_99417b7c36c2 {

 declare precedence: AspectJMLRac$JMLRacPost4Project, AspectJMLRac_* , *;




  /** Generated by AspectJML to check the exceptional postcondition of
   * method ContestacaoRepositorio. */
  after (final br.com.sigcar.repositorios.ContestacaoRepositorio object$rac) throwing (Throwable rac$e) :
     execution(br.com.sigcar.repositorios.ContestacaoRepositorio.new(  )) && this(object$rac) {
           JMLChecker.rethrowJMLAssertionError(rac$e, "br.com.sigcar.repositorios.ContestacaoRepositorio.<init>()");
           boolean rac$b = true;
           String rac$ErrorMsg = "";

  		   if (true) {
  		     if (rac$e instanceof java.lang.RuntimeException) {
  			   java.lang.RuntimeException jml$ex = (java.lang.RuntimeException) rac$e;
  			   boolean rac$b0 = true;
  			   try{			     
  			     rac$b0 = true;
  			   }   catch (JMLNonExecutableException rac$nonExec) {
  			     throw new JMLEvaluationError("Invalid Expression in \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\" by method br.com.sigcar.repositorios.ContestacaoRepositorio.<init>\nCaused by: "+rac$e);
  			   }
  			   if(!rac$b0) {
  			     if(rac$ErrorMsg.equals("")) {
  			       rac$ErrorMsg = "jml$ex";
  			     }
  			     else {
  			       rac$ErrorMsg += " and jml$ex";
  			     }
  			   }
  			   rac$b = rac$b && rac$b0;
           if(rac$ErrorMsg.indexOf("and") >= 0 ){
             rac$ErrorMsg += " are ";
           }
           else{
             rac$ErrorMsg += " is ";
           }
               JMLChecker.checkExceptionalPostcondition(rac$b,"by method br.com.sigcar.repositorios.ContestacaoRepositorio.<init> regarding code at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\""+"\n\t"+rac$ErrorMsg+rac$e, "jml$ex", true, -1, "br.com.sigcar.repositorios.ContestacaoRepositorio.<init>()", rac$e);
  		 }
  		   }
  	 }


  /** Generated by AspectJML to check the exceptional postcondition of
   * method contains. */
  after (final br.com.sigcar.repositorios.ContestacaoRepositorio object$rac, final br.com.sigcar.dominio.Contestacao contestacao) throwing (Throwable rac$e) :
     (execution(boolean br.com.sigcar.repositorios.ContestacaoRepositorio.contains(br.com.sigcar.dominio.Contestacao))) && this(object$rac) && args(contestacao) {
           JMLChecker.rethrowJMLAssertionError(rac$e, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".contains(br.com.sigcar.dominio.Contestacao)");
           boolean rac$b = true;
           String rac$ErrorMsg = "";

  		   if (rac$b && (contestacao != null)) {
  		     if (rac$e instanceof java.lang.Exception) {
  			   java.lang.Exception jml$ex = (java.lang.Exception) rac$e;
  			   boolean rac$b0 = true;
  			   try{			     
  			     rac$b0 = false;
  			   }   catch (JMLNonExecutableException rac$nonExec) {
  			     throw new JMLEvaluationError("Invalid Expression in \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\" by method br.com.sigcar.repositorios.ContestacaoRepositorio.contains\nCaused by: "+rac$e);
  			   }
  			   if(!rac$b0) {
  			     if(rac$ErrorMsg.equals("")) {
  			       rac$ErrorMsg = "jml$ex";
  			     }
  			     else {
  			       rac$ErrorMsg += " and jml$ex";
  			     }
  			   }
  			   rac$b = rac$b && rac$b0;
           if(rac$ErrorMsg.indexOf("and") >= 0 ){
             rac$ErrorMsg += " are ";
           }
           else{
             rac$ErrorMsg += " is ";
           }
               JMLChecker.checkExceptionalPostcondition(rac$b,"by method br.com.sigcar.repositorios.ContestacaoRepositorio.contains regarding code at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\", line 28 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:28)"+"\n\t"+rac$ErrorMsg+rac$e, "jml$ex", true, -1, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".contains(br.com.sigcar.dominio.Contestacao)", rac$e);
  		 }
  		   }
  	 }

  /** Generated by AspectJML to check the exceptional postcondition of
   * method listarContestacoes. */
  after (final br.com.sigcar.repositorios.ContestacaoRepositorio object$rac) throwing (Throwable rac$e) :
     (execution(java.util.List br.com.sigcar.repositorios.ContestacaoRepositorio.listarContestacoes())) && this(object$rac) {
           JMLChecker.rethrowJMLAssertionError(rac$e, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".listarContestacoes()");
           boolean rac$b = true;
           String rac$ErrorMsg = "";

  		   if (true) {
  		     if (rac$e instanceof java.lang.RuntimeException) {
  			   java.lang.RuntimeException jml$ex = (java.lang.RuntimeException) rac$e;
  			   boolean rac$b0 = true;
  			   try{			     
  			     rac$b0 = true;
  			   }   catch (JMLNonExecutableException rac$nonExec) {
  			     throw new JMLEvaluationError("Invalid Expression in \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\" by method br.com.sigcar.repositorios.ContestacaoRepositorio.listarContestacoes\nCaused by: "+rac$e);
  			   }
  			   if(!rac$b0) {
  			     if(rac$ErrorMsg.equals("")) {
  			       rac$ErrorMsg = "jml$ex";
  			     }
  			     else {
  			       rac$ErrorMsg += " and jml$ex";
  			     }
  			   }
  			   rac$b = rac$b && rac$b0;
           if(rac$ErrorMsg.indexOf("and") >= 0 ){
             rac$ErrorMsg += " are ";
           }
           else{
             rac$ErrorMsg += " is ";
           }
               JMLChecker.checkExceptionalPostcondition(rac$b,"by method br.com.sigcar.repositorios.ContestacaoRepositorio.listarContestacoes regarding code at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\", line 58 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:58)"+"\n\t"+rac$ErrorMsg+rac$e, "jml$ex", true, -1, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".listarContestacoes()", rac$e);
  		 }
  		   }
  	 }



  /** Generated by AspectJML to check the precondition of
   * method contains. */
  before (final br.com.sigcar.repositorios.ContestacaoRepositorio object$rac, final br.com.sigcar.dominio.Contestacao contestacao) :
     (execution(boolean br.com.sigcar.repositorios.ContestacaoRepositorio.contains(br.com.sigcar.dominio.Contestacao))) && 
     this(object$rac) && args(contestacao) {
       String preErrorMsg = "by method br.com.sigcar.repositorios.ContestacaoRepositorio.contains regarding specifications at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\", [spec-case]: line 17, character 35 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:17), and \nby method br.com.sigcar.repositorios.ContestacaoRepositorio.contains regarding code at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\", line 28 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:28)"+", when \n"+"\t\'contestacao\' is "+contestacao;
       String evalErrorMsg = "Invalid expression in \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\" by method br.com.sigcar.repositorios.ContestacaoRepositorio.contains regarding specifications at \n[spec-case]: line 17, character 35 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:17)"+", when \n"+"\t\'contestacao\' is "+contestacao+"\nCaused by: ";
       boolean rac$b = true;
       try {
        rac$b = (contestacao != null);
       } catch (JMLNonExecutableException rac$nonExec) {
          rac$b = false;
       } catch (Throwable rac$cause) {
          if(rac$cause instanceof JMLAssertionError) {
            throw (JMLAssertionError) rac$cause;
          }
          else {
            throw new JMLEvaluationError(evalErrorMsg + rac$cause);
          }
       }
       boolean canThrow = false;
       JMLChecker.checkPrecondition(rac$b, canThrow, preErrorMsg, -1, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".contains(br.com.sigcar.dominio.Contestacao)");

     }


  /** Generated by AspectJML to check the precondition, normal and
   * exceptional postcondition of method remover. */
  boolean around (final br.com.sigcar.repositorios.ContestacaoRepositorio object$rac, final br.com.sigcar.dominio.Contestacao entidade) :
     (execution(boolean br.com.sigcar.repositorios.ContestacaoRepositorio.remover(br.com.sigcar.dominio.Contestacao)))
     && this(object$rac) && args(entidade) {
      boolean rac$b = true;
      boolean rac$result = false;
      boolean rac$pre0;
      try {
        // saving pre-expressions and precondition related old vars
  		rac$pre0 = ((entidade != null) && object$rac.contains(entidade));
       } catch (Throwable rac$cause) {
            if(rac$cause instanceof JMLAssertionError) {
              throw (JMLAssertionError) rac$cause;
            }
            else {
              throw new JMLEvaluationError("" + rac$cause);
            }
       }
      String preErrorMsg = "by method br.com.sigcar.repositorios.ContestacaoRepositorio.remover regarding specifications at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\", [spec-case]: line 31, character 33 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:31), and \nby method br.com.sigcar.repositorios.ContestacaoRepositorio.remover regarding code at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\", line 40 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:40)"+", when \n"+"\t\'entidade\' is "+entidade;
      String evalPreErrorMsg = "Invalid expression in \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\" by method br.com.sigcar.repositorios.ContestacaoRepositorio.remover regarding specifications at \n[spec-case]: line 31, character 33 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:31)"+", when \n"+"\t\'entidade\' is "+entidade+"\nCaused by: ";
      try {
        rac$b = ((entidade != null) && object$rac.contains(entidade));
       } catch (JMLNonExecutableException rac$nonExec) {
          rac$b = false;
       } catch (Throwable rac$cause) {
          if(rac$cause instanceof JMLAssertionError) {
            throw (JMLAssertionError) rac$cause;
          }
          else {
            throw new JMLEvaluationError(evalPreErrorMsg + rac$cause);
          }
       }
       boolean canThrow = false;
       JMLChecker.checkPrecondition(rac$b, canThrow, preErrorMsg, -1, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".remover(br.com.sigcar.dominio.Contestacao)");
      try {
        rac$result = proceed(object$rac, entidade);//executing the method
        String nPostErrorMsg =  "";
        String evalErrorMsg = "";
      } catch (Throwable rac$e) {
           rac$b = true;
           String rac$ErrorMsg = "";

  		   if (rac$b && rac$pre0) {
  		     if (rac$e instanceof java.lang.Exception) {
  			   java.lang.Exception jml$ex = (java.lang.Exception) rac$e;
  			   boolean rac$b0 = true;
  			   try{			     
  			     rac$b0 = false;
  			   }   catch (JMLNonExecutableException rac$nonExec) {
  			     throw new JMLEvaluationError("Invalid Expression in \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\" by method br.com.sigcar.repositorios.ContestacaoRepositorio.remover\nCaused by: "+rac$e);
  			   }
  			   if(!rac$b0) {
  			     if(rac$ErrorMsg.equals("")) {
  			       rac$ErrorMsg = "jml$ex";
  			     }
  			     else {
  			       rac$ErrorMsg += " and jml$ex";
  			     }
  			   }
  			   rac$b = rac$b && rac$b0;
           if(rac$ErrorMsg.indexOf("and") >= 0 ){
             rac$ErrorMsg += " are ";
           }
           else{
             rac$ErrorMsg += " is ";
           }
               JMLChecker.checkExceptionalPostcondition(rac$b,"by method br.com.sigcar.repositorios.ContestacaoRepositorio.remover regarding code at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\", line 40 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:40)"+"\n\t"+rac$ErrorMsg+rac$e, "jml$ex", true, -1, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".remover(br.com.sigcar.dominio.Contestacao)", rac$e);
  		 }
  		   }
           if(JMLChecker.hasAnyJMLError){
            JMLChecker.rethrowJMLAssertionError(rac$e, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".remover(br.com.sigcar.dominio.Contestacao)");
           }
           if(!JMLChecker.hasAnyJMLError) {
  			 JMLChecker.rethrowUncheckedException(rac$e);
  		   }
  			 throw new JMLSoftException(rac$e);
  		}
      return rac$result;
  	}

  /** Generated by AspectJML to check the precondition, normal and
   * exceptional postcondition of method salvar. */
  boolean around (final br.com.sigcar.repositorios.ContestacaoRepositorio object$rac, final br.com.sigcar.dominio.Contestacao entidade) :
     (execution(boolean br.com.sigcar.repositorios.ContestacaoRepositorio.salvar(br.com.sigcar.dominio.Contestacao)))
     && this(object$rac) && args(entidade) {
      boolean rac$b = true;
      boolean rac$result = false;
      boolean rac$pre0;
      try {
        // saving pre-expressions and precondition related old vars
  		rac$pre0 = ((entidade != null) && !(object$rac.contains(entidade)));
       } catch (Throwable rac$cause) {
            if(rac$cause instanceof JMLAssertionError) {
              throw (JMLAssertionError) rac$cause;
            }
            else {
              throw new JMLEvaluationError("" + rac$cause);
            }
       }
      String preErrorMsg = "by method br.com.sigcar.repositorios.ContestacaoRepositorio.salvar regarding specifications at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\", [spec-case]: line 42, character 33 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:42), and \nby method br.com.sigcar.repositorios.ContestacaoRepositorio.salvar regarding code at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\", line 54 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:54)"+", when \n"+"\t\'entidade\' is "+entidade;
      String evalPreErrorMsg = "Invalid expression in \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\" by method br.com.sigcar.repositorios.ContestacaoRepositorio.salvar regarding specifications at \n[spec-case]: line 42, character 33 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:42)"+", when \n"+"\t\'entidade\' is "+entidade+"\nCaused by: ";
      try {
        rac$b = ((entidade != null) && !(object$rac.contains(entidade)));
       } catch (JMLNonExecutableException rac$nonExec) {
          rac$b = false;
       } catch (Throwable rac$cause) {
          if(rac$cause instanceof JMLAssertionError) {
            throw (JMLAssertionError) rac$cause;
          }
          else {
            throw new JMLEvaluationError(evalPreErrorMsg + rac$cause);
          }
       }
       boolean canThrow = false;
       JMLChecker.checkPrecondition(rac$b, canThrow, preErrorMsg, -1, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".salvar(br.com.sigcar.dominio.Contestacao)");
      try {
        rac$result = proceed(object$rac, entidade);//executing the method
        String nPostErrorMsg =  "";
        String evalErrorMsg = "";
      } catch (Throwable rac$e) {
           rac$b = true;
           String rac$ErrorMsg = "";

  		   if (rac$b && rac$pre0) {
  		     if (rac$e instanceof java.lang.Exception) {
  			   java.lang.Exception jml$ex = (java.lang.Exception) rac$e;
  			   boolean rac$b0 = true;
  			   try{			     
  			     rac$b0 = false;
  			   }   catch (JMLNonExecutableException rac$nonExec) {
  			     throw new JMLEvaluationError("Invalid Expression in \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\" by method br.com.sigcar.repositorios.ContestacaoRepositorio.salvar\nCaused by: "+rac$e);
  			   }
  			   if(!rac$b0) {
  			     if(rac$ErrorMsg.equals("")) {
  			       rac$ErrorMsg = "jml$ex";
  			     }
  			     else {
  			       rac$ErrorMsg += " and jml$ex";
  			     }
  			   }
  			   rac$b = rac$b && rac$b0;
           if(rac$ErrorMsg.indexOf("and") >= 0 ){
             rac$ErrorMsg += " are ";
           }
           else{
             rac$ErrorMsg += " is ";
           }
               JMLChecker.checkExceptionalPostcondition(rac$b,"by method br.com.sigcar.repositorios.ContestacaoRepositorio.salvar regarding code at \nFile \"br.com.sigcar.repositorios.ContestacaoRepositorio.java\", line 54 (br.com.sigcar.repositorios.ContestacaoRepositorio.java:54)"+"\n\t"+rac$ErrorMsg+rac$e, "jml$ex", true, -1, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".salvar(br.com.sigcar.dominio.Contestacao)", rac$e);
  		 }
  		   }
           if(JMLChecker.hasAnyJMLError){
            JMLChecker.rethrowJMLAssertionError(rac$e, object$rac.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object$rac))+".salvar(br.com.sigcar.dominio.Contestacao)");
           }
           if(!JMLChecker.hasAnyJMLError) {
  			 JMLChecker.rethrowUncheckedException(rac$e);
  		   }
  			 throw new JMLSoftException(rac$e);
  		}
      return rac$result;
  	}

}
