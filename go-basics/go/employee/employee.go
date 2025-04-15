package employee

import (
	"fmt"
	"gobasics/person"
)

type Employee struct {
	P person.Individual
	id string
}

type Social interface{
	Greet()
}

func NewEmployee(id, name string, age int) Employee{
	return Employee{
		id: id,
		P: person.NewPerson(name, age),
	}
}

func (e *Employee) Greet(){
	fmt.Println("Greetings coworker")
}