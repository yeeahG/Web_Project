package kpizza.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class ClientDTO {
	private int sort_no;
	private String client_id;
	private String password;
	private String name;
	private String nickname;
	private String contact;
	private String address;
}
