package TSP;

public class SA extends Information implements Algorithm{
    private double temp, coefficient, energy, newEnergy;

    public SA(){
        super(); // Extiendo Information (variables necesarias)
        setTemp(100000); //Pongos mis propias variables.
        setCoefficient(0.0003);
    }

    public SA(double temp, double coefficient){
        super();
        setTemp(temp);
        setCoefficient(coefficient);
    }

    public Route getBestRoute(){ return super.bestRoute; }
    public long getRuntime() { return super.timer; }
    public double getShortestDistance() { return super.shortestDistance;}
    public long getIterations() { return super.iterations; }

    public void setTemp(double temp) { this.temp = temp; }
    public void setCoefficient(double coefficient) { this.coefficient = coefficient; }
    public void setEnergy(double energy) { this.energy = energy; }
    public void setNewEnergy(double newEnergy) { this.newEnergy = newEnergy; }

    public double getTemp() { return temp; }
    public double getCoefficient() { return coefficient; }
    public double getEnergy() { return energy; }
    public double getNewEnergy() { return newEnergy; }

    public void solve(CityRecorder recorder){

        long startTime = System.nanoTime();
        super.recorder = recorder;

        Route currentRoute = new Route(recorder);
        currentRoute.fillCities(recorder); //Crear una ruta con ciudades del recorder al azar

        super.bestRoute = new Route(recorder);
        bestRoute.cloneRoute(currentRoute.getRoute());

        while(getTemp() > 1) {
            Route nextRoute = new Route(recorder);   // Inicializamos nuestra ruta a considerar
            nextRoute.cloneRoute(currentRoute.getRoute());

            // Agarramos dos posiciones al azar (de 0 al tamaño de la lista)
            int randomPos_1 = (int) (nextRoute.getSize() * Math.random());
            int randomPos_2 = (int) (nextRoute.getSize() * Math.random());

            // Intercambiamos las ciudades en las posiciones que se eligieron
            City swayCity_1 = nextRoute.getCity(randomPos_1);
            City swapCity_2 = nextRoute.getCity(randomPos_2);
            nextRoute.setCity(randomPos_2, swayCity_1);
            nextRoute.setCity(randomPos_1, swapCity_2);

            //Revisamos la nueva distancia creada
            setEnergy(currentRoute.getDistance());
            setNewEnergy(nextRoute.getDistance());

            //Verificamos si nuestra ruta es "buena"
            if(checkProbability(getEnergy(),getNewEnergy()) > Math.random()){
                currentRoute.cloneRoute(nextRoute.getRoute());
            }
            //Si llega a ser mejor que la que ya teníamos, se vuelve la mejor ruta
            if (currentRoute.getDistance() < bestRoute.getDistance()) {
                bestRoute.cloneRoute(currentRoute.getRoute());
            }

            // Reducimos nuestra temperatura
            setTemp(getTemp()*(1-getCoefficient()));
            super.iterations += 1;

        }
        long endTime = System.nanoTime();
        runtime(startTime, endTime); // milis: /1000000
        // Metodos que imprimen los resultados
        
        super.shortestDistance = bestRoute.getDistance();
        printShortestDistance();
        printShortestRoute();
       
        
    }

    private double checkProbability(double energy, double newEnergy) {
        if (newEnergy < energy) {
            return 1.0;
        }
        return Math.exp((energy - newEnergy) / getTemp());
    }

    public void runtime(long start, long end){
        super.timer = (end - start)/1000000;
    }

    // Imprime la distancia más corta encontrada
    public void printShortestDistance(){
        System.out.printf("Final solution distance: %.2f (Time: %d milis.)\n", getShortestDistance(), getRuntime());
    }

    // Imprime la ruta mas corta encontrada y las iteraciones totales
    public void printShortestRoute(){
        System.out.println("Shortest Route: \n" + getBestRoute());
        System.out.println("Iterations: " + getIterations());
    }
}
