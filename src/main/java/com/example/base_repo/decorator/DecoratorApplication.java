package com.example.base_repo.decorator;

public class DecoratorApplication {
    public static void main(String[] args) {
        String defaultMessage = "Hello World";
        String password = "Password";
        String additionalString = "Some text";
        String allDecorators = "Decorators";


        DataSourceDecorator dataSourceDecorator = new DataSourceDecorator(new FileDataSource(defaultMessage));
        dataSourceDecorator.writeData(defaultMessage);
        System.out.println("--------------------------------");
        System.out.println(dataSourceDecorator.readData());

        DataSourceDecorator dataSourcePasswordDecorator = new EncryptionDecorator(
                new DataSourceDecorator(
                        new FileDataSource(password)));
        dataSourcePasswordDecorator.writeData(password);
        System.out.println("--------------------------------");
        System.out.println(dataSourcePasswordDecorator.readData());

        DataSourceDecorator dataSourceAdditionalDecorator = new AdditionalDateDecorator(
                new DataSourceDecorator(
                        new FileDataSource(additionalString)));
        dataSourceAdditionalDecorator.writeData(additionalString);
        System.out.println("--------------------------------");
        System.out.println(dataSourceAdditionalDecorator.readData());

        DataSourceDecorator dataSourceAllDecorators =
                new AdditionalDateDecorator(
                        new EncryptionDecorator(
                                new DataSourceDecorator(
                                        new FileDataSource(allDecorators))));
        dataSourceAllDecorators.writeData(allDecorators);
        System.out.println("--------------------------------");
        System.out.println(dataSourceAllDecorators.readData());

    }
}
