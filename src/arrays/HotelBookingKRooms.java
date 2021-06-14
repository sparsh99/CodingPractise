package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBookingKRooms {

  public static void main(String[] args) {
    ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 3, 5));
    ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2, 6, 8));
    System.out.println(new HotelBookingKRooms().hotel(arrive, depart, 1));
  }

  public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    Collections.sort(arrive);
    Collections.sort(depart);

    int i=0;
    int j=0;
    int currentCust = 0;
    while (i < arrive.size() && j < depart.size()) {
      if (arrive.get(i) < depart.get(j)) {
        i++;
        currentCust++;
      } else {
        j++;
        currentCust--;
      }

      if (currentCust > K) {
        return false;
      }
    }

    return true;
  }
}
