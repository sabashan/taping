package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@SuppressWarnings({ "serial"})
@Embeddable
@XmlRootElement
@Indexed
public class MstusersecurityId extends BaseObject implements Serializable {
    private String userId;
    private Long programId;
    
    public MstusersecurityId() {

	}

    public MstusersecurityId(String userId, Long programId) {
		super();
		this.userId = userId;
		this.programId = programId;
	}

	@Column(name="user_id", nullable=false, length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name="program_id", nullable=false)
    @Field
    public Long getProgramId() {
        return this.programId;
    }
    
    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MstusersecurityId pojo = (MstusersecurityId) o;

        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (programId != null ? !programId.equals(pojo.programId) : pojo.programId != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = (programId != null ? programId.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("programId").append("='").append(getProgramId()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
