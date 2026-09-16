package br.pucpr.planet;

public record Planet(String name, double diameterKm, long sunDistanceKm, PlanetType type) {
  public static final long DISTANCIA_TERRA_SOL = 149_600_000L;

  public double getDistanciaUa() {
    return (double) sunDistanceKm / DISTANCIA_TERRA_SOL;
  }
}
