package Builder;

public class BuilderExample {
    private final String name;
    private final Integer age;

    // package visibility
    BuilderExample(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // static method to get the builder object to build outer class
    public static BuilderExample.Builder builder() {
        return new BuilderExample.Builder();
    }

    // Get Builder object with current fields to create new object with modified fields
    public BuilderExample.Builder toBuilder() {
        return (new BuilderExample.Builder()).name(this.name).age(this.age);
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public static class Builder {
        // not final fields
        private String name;
        private Integer age;

        Builder() {
        }

        public BuilderExample.Builder name(String name) {
            this.name = name;
            return this;
        }

        public BuilderExample.Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public BuilderExample build() {
            return new BuilderExample(this.name, this.age);
        }

        public String toString() {
            return "BuilderExample.Builder(name=" + this.name + ", age=" + this.age + ")";
        }
    }
}
