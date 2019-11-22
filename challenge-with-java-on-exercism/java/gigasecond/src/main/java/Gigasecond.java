import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

class Gigasecond {
	
	private static final long GIGA = 1000000000L;
	private long miliseconds;
	
    Gigasecond(LocalDate moment) {
    	this.miliseconds = moment.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    Gigasecond(LocalDateTime moment) {
    	this.miliseconds = moment.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    	
    }

    LocalDateTime getDateTime() {
    	Instant in = Instant.ofEpochSecond(miliseconds + GIGA);
        return in.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
