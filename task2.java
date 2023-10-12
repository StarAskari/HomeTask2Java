import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class task2 {
    public static class Car {
        private int id;
        private String Make;
        private String Model;
        private int YearOfManufacture;
        private String Color;
        private Double Price;
        private String RegistrationNumber;

        public  Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
            this.id = id;
            this.Make = make;
            this.Model = model;
            this.YearOfManufacture = yearOfManufacture;
            this.Color = color;
            this.Price = price;
            this.RegistrationNumber = registrationNumber;
        }

        public String getMake() {
            return Make;
        }

        public String getModel() {
            return Model;
        }

        public int getYearOfManufacture() {
            return YearOfManufacture;
        }

        public double getPrice() {
            return Price;
        }
    }



        public static void main(String[] args) {
            // Create an array of Car objects
            List<Car> cars = new ArrayList<>();
            cars.add(new Car(1, "Toyota", "Camry", 2019, "Blue", 25000.0, "ABC123"));
            cars.add(new Car(2, "Honda", "Civic", 2020, "Red", 22000.0, "XYZ456"));
            cars.add(new Car(2, "BMW", "s", 20220, "Black", 23000.0, "ASD789"));

            List<Car> carsByMake = getCarsByMake(cars, "BMW");
            saveCarsToFile(carsByMake, "C:\\Users\\Setareh\\Desktop\\Java\\carModel.txt");
            List<Car> carsByModelAndAge = getCarsByModelAndAge(cars, "Camry", 3); // Cars older than 3 years
            saveCarsToFile(carsByModelAndAge, "C:\\Users\\Setareh\\Desktop\\Java\\carAge.txt");
            List<Car> carsByYearAndPrice = getCarsByYearAndPrice(cars, 2020, 20000.0); // Cars from 2020 with price > 20000
            saveCarsToFile(carsByYearAndPrice, "C:\\Users\\Setareh\\Desktop\\Java\\carPrice.txt");
        }

        public static void saveCarsToFile(List<Car> cars, String filename) {
            try {

                // Create a FileWriter object
                // to write in the file
                PrintWriter writer = new PrintWriter(new FileWriter(filename));

                // Writing into file
                // Note: The content taken above inside the
                // string

                for (Car car : cars) {
                    // Maybe:

                    writer.write(car.Make+" ");
                    writer.write(car.Model+" ");
                    writer.write(car.YearOfManufacture+" ");
                    writer.write(car.Color+" ");
                    writer.write(car.RegistrationNumber+" ");


                }


                // Printing the contents of a file
                //System.out.println(cars.toString());

                // Closing the file writing connection
                writer.close();

                // Display message for successful execution of
                // program on the console
                System.out.println(
                        "File is created successfully with the content.");
            }

            // Catch block to handle if exception occurs
            catch (IOException e) {

                // Print the exception
                System.out.print(e.getMessage());
            }
        }

        public static List<Car> getCarsByMake(List<Car> cars, String make) {
            List<Car> filteredCars = new ArrayList<>();
            for (Car car : cars) {
                if (car.getMake().equals(make)) {
                    filteredCars.add(car);
                }
            }
            return filteredCars;
        }

        public static List<Car> getCarsByModelAndAge(List<Car> cars, String model, int n) {
            List<Car> filteredCars = new ArrayList<>();
            int currentYear = java.time.Year.now().getValue();
            for (Car car : cars) {
                if (car.getModel().equals(model) && (currentYear - car.getYearOfManufacture()) > n) {
                    filteredCars.add(car);
                }
            }
            return filteredCars;
        }

        public static List<Car> getCarsByYearAndPrice(List<Car> cars, int year, double minPrice) {
            List<Car> filteredCars = new ArrayList<>();
            for (Car car : cars) {
                if (car.getYearOfManufacture() == year && car.getPrice() > minPrice) {
                    filteredCars.add(car);
                }
            }
            return filteredCars;
        }

}