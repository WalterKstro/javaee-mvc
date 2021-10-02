/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.walterkstro.model;

import java.text.NumberFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author walte
 */

@Data
@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private int CustomerID;
    private String CustomerFirstName;
    private String CustomerLastName;
    private String CustomerEmail;
    private String CustomerPhone;
    private double CustomerBalance;

    public Customer(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Customer(String CustomerFirstName, String CustomerLastName, String CustomerEmail, String CustomerPhone, double CustomerBalance) {
        this.CustomerFirstName = CustomerFirstName;
        this.CustomerLastName = CustomerLastName;
        this.CustomerEmail = CustomerEmail;
        this.CustomerPhone = CustomerPhone;
        this.CustomerBalance = CustomerBalance;
    }
    
    public String formatBalance(){
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        return defaultFormat.format(this.CustomerBalance);
    }
    
}
