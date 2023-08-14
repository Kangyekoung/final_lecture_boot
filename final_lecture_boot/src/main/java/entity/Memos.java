package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="memos")
@Getter
@Setter
public class Memos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int memoseq;
	@Column(length=200, nullable=false)
	String contents;
	@ManyToOne(cascade = CascadeType.ALL)  
	@JoinColumn(name="Users", referencedColumnName = "id")
	Users writer;//Users객체 id변수 참조(fk)
}
