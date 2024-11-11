package ru.mirea.klishenkovai;

import java.util.Scanner;

public class PkmnApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла: ");
        String fileName = scanner.nextLine();
        CardImport cardImport = new CardImport(fileName);
        Card card = cardImport.card;
        //ffff
        if (card != null) {

            // Сохранение карты в файл
            CardExport cardExport = new CardExport();
            cardExport.saveCard(card);

            // Загрузка другой карты
            System.out.print("Введите путь к файлу карты для загрузки (.crd): ");
            String filePath = scanner.nextLine();
            Card loadedCard = cardImport.loadCardFromFile(filePath);

            if (loadedCard != null) {
                System.out.println("Загруженная карта: ");
                //вывод при загруженная карта

                // Вывод информации о загруженной карточке
                System.out.println("Имя покемона: " + card.getName());
                System.out.println("Стадия покемона: " + card.getPokemonStage());
                System.out.println("HP: " + card.getHp());
                System.out.println("Тип покемона: " + card.getPokemonType());
                System.out.println("Способности покемона:");

                for (AttackSkill attack : card.getSkills()) {
                    System.out.println("- " + attack.getName() + " (Цена: " + attack.getCost() + ", Урон: " + attack.getDamage() + ")");
                }

                // Дополнительная информация
                if (card.getEvolvesFrom() != null) {
                    System.out.println("Эволюционирует из: " + card.getEvolvesFrom().getName());
                }
                if (card.getWeaknessType() != null) {
                    System.out.println("Тип слабости: " + card.getWeaknessType());
                }
                if (card.getResistanceType() != null) {
                    System.out.println("Сопротивление: " + card.getResistanceType());
                }
                System.out.println("Цена побега: " + card.getRetreatCost());
                System.out.println("Название сета: " + card.getGameSet());
                System.out.println("Отметка легальности: " + card.getRegulationMark());
                System.out.println("Владелец карты: " + card.getPokemonOwner().getName());
                //окончание вывода
            } else {
                System.out.println("Не удалось загрузить карту.");
            }
        } else {
            System.out.println("Не удалось загрузить карту.");
        }
        //ffff
    }
}
