package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
	
	private Integer numeroDoQuarto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroDoQuarto, LocalDate checkIn, LocalDate checkOut) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		Duration diferenca = Duration.between(checkIn.atStartOfDay(),checkOut.atStartOfDay());
		return diferenca.toDays();
	}
	
	public String atualizarDatas(LocalDate checkIn, LocalDate checkOut) {
		LocalDate agora = LocalDate.now();
		if (checkIn.isBefore(agora) || checkOut.isBefore(agora)) {
			return "Erro na reserva: a data para atualização precisa ser datas futuras!";
		}
		if (checkOut.isBefore(checkIn)) {
			return "Erro na reserva: a data de check-out deve ser após a data de check-in!";
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroDoQuarto
				+ ", check-in: "
				+ checkIn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", check-out: "
				+ checkOut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", "
				+ duracao()
				+ " noite(s)";
	}

}
