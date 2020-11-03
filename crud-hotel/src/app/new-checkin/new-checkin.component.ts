import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Checkin } from '../models/checkin/checkin';
import { Hospede } from '../models/person/hospede';

@Component({
  selector: 'app-new-checkin',
  templateUrl: './new-checkin.component.html',
  styleUrls: ['./new-checkin.component.sass']
})
export class NewCheckinComponent implements OnInit {

  checkin: Checkin = new Checkin();

  id: number;
  dataGuest: string;
  dateIn: string;
  dateOut: string;
  plusCar: boolean;

  constructor(private hotelService: HotelService) { }

  ngOnInit(): void {
  }

  updateCheckin(id: number, checkin: Checkin) {

      this.hotelService.updateCheckin(id, checkin).subscribe(data => {    
    
       window.location.reload()
      }, error => console.log(error))
  }

  saveCheckin(checkin: Checkin) {

    this.hotelService.createCheckin(checkin).subscribe(data => {

      window.location.reload()
      
    }, error => console.log(error))
  }

  getCheckinById(guest: Hospede) {

}

  getGuestById(dataGuest: string) {
  
    this.hotelService.getGuestsList().subscribe(allGuests => {

      for (var i = 0; i < allGuests.length; i++) {
        this.hotelService.getGuestById(allGuests[i].id).subscribe(guest => {

          if (guest.documento == dataGuest || guest.nome == dataGuest || guest.telefone == dataGuest) {
            this.getCheckinById(guest);

          }

        }, error => console.log(error))
      }
  
    }, error => console.log(error))
  }

  onSubmit() {

    if (this.plusCar == undefined) {
      this.plusCar = false
    }

    if ((this.dataGuest != undefined && this.dataGuest != "")) {

      this.getGuestById(this.dataGuest)

    } else {
      alert("O campo Documento é obrigatório")
      return;
    }
    
  }
}
