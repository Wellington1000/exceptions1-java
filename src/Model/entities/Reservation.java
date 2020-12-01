
package Model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    
    private Integer rooamNumber;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservation(){}

    public Reservation(Integer rooamNumber, Date checkIn, Date checkOut) {
        this.rooamNumber = rooamNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRooamNumber() {
        return rooamNumber;
    }

    public void setRooamNumber(Integer rooamNumber) {
        this.rooamNumber = rooamNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    

    public Date getCheckOut() {
        return checkOut;
    }

    
    public long duration() {
        //Diferença entre datas
        long diff = checkOut.getTime() - checkIn.getTime(); //Milisegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //Converte milisegundos para dias
    }
    
    
    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    
    @Override
    public String toString(){
        return "Rooms "
                + rooamNumber
                + ", check-in:"
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                +", "
                + duration()
                + " nigths";
    }
    
}
