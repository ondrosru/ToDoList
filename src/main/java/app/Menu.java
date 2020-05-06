package app;

import app.commands.*;
import app.domains.deal.DealStatus;
import app.domains.deal.IDeal;
import app.domains.list.IDealList;
import app.factories.DealFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<IDealList> dealLists;

    public Menu(ArrayList<IDealList> dealLists) {
        this.dealLists = dealLists;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int num;
            System.out.println("Меню:");
            System.out.println("[1] Добавить список");
            System.out.println("[2] Добавить дело");
            System.out.println("[3] Удалить список");
            System.out.println("[4] Удалить дело");
            System.out.println("[5] Изменить статус у дела");
            System.out.println("[6] Просмотр дел из списка");
            System.out.println("[7] Выход");
            num = Integer.parseInt(scan.nextLine());

            try {
                if (num == 7) {
                    break;
                }
                Command command = null;
                IDeal deal;
                IDealList dealList;
                switch (num) {
                    case 1:
                        System.out.println("Введите названия нового списка: ");
                        String name = scan.nextLine();
                        command = new AddDealList(dealLists, name);
                        break;
                    case 2:
                        dealList = SelectList();
                        if (dealList != null) {
                            System.out.println("Введите описание дела: ");
                            String description = scan.nextLine();
                            deal = DealFactory.create(description);
                            command = new AddDeal(dealList, deal);
                        } else {
                            System.out.println("Нет списков.");
                        }
                        break;
                    case 3:
                        dealList = SelectList();
                        if (dealList != null) {
                            command = new RemoveDealList(dealLists, dealList);
                        } else {
                            System.out.println("Нет списков.");
                        }
                        break;
                    case 4:
                        dealList = SelectList();
                        if (dealList != null) {
                            deal = SelectDeal(dealList);
                            if (deal != null) {
                                command = new RemoveDeal(dealList, deal);
                            } else {
                                System.out.println("Нет дел.");
                            }

                        } else {
                            System.out.println("Нет списков.");
                        }
                        break;
                    case 5:

                        dealList = SelectList();
                        if (dealList != null) {
                            deal = SelectDeal(dealList);
                            if (deal != null) {
                                DealStatus status = SelectStatus();
                                command = new SetStatus(deal, status);
                            } else {
                                System.out.println("Нет дел.");
                            }
                        } else {
                            System.out.println("Нет списков.");
                        }
                        break;
                    case 6:
                        dealList = SelectList();
                        if (dealList != null) {
                                command = new ViewDeals(dealList);
                        } else {
                            System.out.println("Нет списков.");
                        }
                        break;
                    default:
                        System.out.println("Неверный ввод");
                        break;
                }
                if (command != null) {
                    command.execute();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<IDealList> getDealLists() {
        return this.dealLists;
    }

    private IDealList SelectList() {
        IDealList dealList = null;
        if (this.dealLists.size() != 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Выберите список: ");
            for (int i = 1; i <= dealLists.size(); i++) {
                System.out.println("[" + i + "]" + this.dealLists.get(i - 1).getName());
            }
            int num;

            while (true) {
                num = Integer.parseInt(scan.nextLine());
                if (num <= dealLists.size()) {
                    dealList = dealLists.get(num - 1);
                    break;
                } else {
                    System.out.println("Неверный ввод");
                }
            }
        }
        return dealList;
    }

    private IDeal SelectDeal(IDealList dealList) {
        ArrayList<IDeal> deals = dealList.getDeals();
        IDeal deal = null;
        if (deals.size() != 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Выберите дело: ");
            for (int i = 1; i <= deals.size(); i++) {
                System.out.println("[" + i + "]" + deals.get(i - 1));
            }

            int num;
            while (true) {
                num = Integer.parseInt(scan.nextLine());
                if (num <= deals.size()) {
                    deal = deals.get(num - 1);
                    break;
                } else {
                    System.out.println("Неверный ввод");
                }
            }
        }
        return deal;
    }

    private DealStatus SelectStatus() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите статус: ");
        DealStatus[] statuses = DealStatus.values();
        for (int i = 1; i <= statuses.length; i++) {
            System.out.println("[" + i + "]" + statuses[i - 1].toString());
        }
        DealStatus status;
        int num;
        while (true) {
            num = Integer.parseInt(scan.nextLine());
            if (num <= statuses.length) {
                status = statuses[num - 1];
                break;
            } else {
                System.out.println("Неверный ввод");
            }
        }
        return status;
    }
}
