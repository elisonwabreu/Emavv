package org.entities.classes;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class tb_matriculas implements Serializable {
    
    @Id
    public int codigo;
    public int aluno;
    public Date dataMatricula;
    public int usuario;

    public int getCodigo() {
        return codigo;
    }

   

   
}
