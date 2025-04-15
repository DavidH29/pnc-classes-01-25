package main

import (
	"errors"
	"fmt"
	"gobasics/employee"
	"gobasics/person"
	"time"
)

func main() {
	fmt.Println("xd")

	const c = 5

	for i := 0; i < 10; i++ {
		fmt.Println(i)
	}

	j := 1
	for j < 20 {
		fmt.Println(j)
		j = j * 2
	}

	i := 0
	for {
		fmt.Println(j, i)
		break

	}

	for n := range 6 {
		fmt.Println(n)
	}

	if 7%2 == 0 {
		fmt.Print("even")
	} else {
		fmt.Println("odd")
	}

	dayOfWeek := 2
	switch dayOfWeek {
	case 1, 4, 5:
		fmt.Println("Monday")
	case 2:
		fmt.Println("Tuesday")
	case 3:
		fmt.Println("Wenesday")
	default:
		fmt.Println("Invalid")
	}

	t := time.Now()
	switch {
	case t.Hour() > 12:
		fmt.Println("Afternoon")
	}

	age, ok := isOverAge(12)
	fmt.Println(age, ok)
	if ok != nil {
		//TODO: Manage error
	}
	age, ok = isOverAge(-5)
	fmt.Println(age, ok)

	if age, ok = isOverAge(20); ok != nil {
		//TODO: Manage error
	}

	fmt.Println("COLECTIONS -----------------")
	var s []int

	s = make([]int, 3, 100)
	fmt.Println(s, len(s), cap(s))

	s = append(s, 1)
	fmt.Println(s, len(s), cap(s))
	
	s = append(s, 1)
	s = append(s, 1)
	fmt.Println(s, len(s), cap(s))

	s = append(s, 1)
	fmt.Println(s, len(s), cap(s))

	s = s[2:len(s)-1]
	fmt.Println(s, len(s), cap(s))

	m := make(map[string]int)

	m["a"] = 1
	m["b"] = 2

	println(m["b"])
	m["b"] = 100
	println(m["b"])

	for k, _ := range m {
		fmt.Println(k)
	}

	p := person.NewPerson("Jorge", 20)

	fmt.Println(p)

	p.SetName("Alex")
	fmt.Println(p)
	fmt.Println(p.GetName())

	e := employee.NewEmployee("00001", "Marty", 30)
	fmt.Println(e)

	fmt.Println(e.P.GetName())
	Greetings(&e)
}

func isOverAge(n int) (bool, error) {
	if n < 0 {
		return false, errors.New("Negative number")
	} else if n > 18 {
		return true, nil
	} else {
		return false, nil
	}

}

func Greetings(s employee.Social){
	s.Greet()
}