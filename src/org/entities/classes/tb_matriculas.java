package org.entities.classes;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;

@Entity
public class tb_matriculas implements Serializable {
    
    public int codigo;
    public int aluno;
    public Date dataMatricula;
    public int usuario;

   
}
