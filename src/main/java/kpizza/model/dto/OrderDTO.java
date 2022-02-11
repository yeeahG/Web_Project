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

public class OrderDTO {

	private int order_list_id;      
    private String order_list_name; 
    private String client_id;         
    private String food_id;	       
    private int food_quantity;    
    private String food_id2;	        
    private int food2_quantity;     
    private int total_price; 	
    private String message;           
}
