package JavaFX_project.Database;

public class TableParameterDescription {

    private String parameter_name;          // Nazwa_parametru
    private String parameter_description;   // Opis_parametru

    public TableParameterDescription() {
    }

    public TableParameterDescription(String parameter_name, String parameter_description) {
        this.parameter_name = parameter_name;
        this.parameter_description = parameter_description;
    }

    public void setParameter_name(String parameter_name) {
        this.parameter_name = parameter_name;
    }

    public void setParameter_description(String parameter_description) {
        this.parameter_description = parameter_description;
    }

    @Override
    public String toString() {
        return parameter_name + " - " + parameter_description;
    }
}
