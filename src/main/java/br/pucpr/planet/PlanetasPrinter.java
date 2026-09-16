package br.pucpr.planet;

import br.pucpr.user.Theme;
import java.util.ArrayList;

public class PlanetasPrinter {

  public void print(ArrayList<Planet> planets, boolean alignRight, Theme theme) {
    if (planets == null || planets.isEmpty()) {
      System.out.println("ERRO: Lista de planetas vazia ou nula.");
      return;
    }

    String borderChar = theme.getBorderChar();
    int borderWidth = 86;
    StringBuilder sb = new StringBuilder();

    sb.repeat(borderChar, borderWidth).append("\n");
    sb.append(
        String.format(
            "| %-20s | %-10s | %-15s | %-15s | %-10s |%n",
            "Nome", "Diâmetro", "Dist. sol (km)", "Dist. sol (ua)", "Tipo"));
    sb.repeat(borderChar, borderWidth).append("\n");

    for (Planet planet : planets) {
      if (planet == null) {
        continue;
      }
      sb.append(
          String.format(
              "| %-20s | %,10.1f | %,15d | %,15.2f | %-10s |%n",
              formatNome(planet),
              planet.diameterKm(),
              planet.sunDistanceKm(),
              planet.getDistanciaUa(),
              formatTipo(planet.type())));
    }

    sb.repeat(borderChar, borderWidth).append("\n");

    if (alignRight) {
      String[] lines = sb.toString().split("\n");
      for (String line : lines) {
        System.out.println("                    " + line);
      }
    } else {
      System.out.print(sb);
    }
  }

  private static String formatNome(Planet planet) {
    String nome = planet.name();
    if (nome == null || nome.isEmpty()) {
      return "NÃO INFORMADO";
    }
    if (nome.length() > 20) {
      nome = nome.substring(0, 17) + "...";
    }
    return nome;
  }

  private static String formatTipo(PlanetType tipo) {
    if (tipo == null) {
      return "NÃO INFORMADO";
    }
    switch (tipo) {
      case ROCK:
        return "Rochoso";
      case GAS:
        return "Gasoso";
      case ICE:
        return "Gelado";
      case DWARF:
        return "Anão";
      default:
        return "";
    }
  }
}
