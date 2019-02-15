package com.LendingClub.demo.config;
 
import com.LendingClub.demo.model.Hotels;
import org.springframework.batch.item.ItemProcessor;


 
public class DBLogProcessor implements ItemProcessor<Hotels, Hotels>
{
    public Hotels process(Hotels Hotel) throws Exception
    {
        System.out.println("Inserting Hotels : " + Hotel);
        return Hotel;
    }
}