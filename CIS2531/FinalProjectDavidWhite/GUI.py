import tkinter as tk
from tkinter import messagebox as mb
from tkinter import filedialog as fd
import Contact


# David White
# 2022/11/28
# CIS-5031
# Instructor: Carolyn England
# Assignment: Final Project
# Description:


class GUI:
    def __init__(self):
        # read from file
        self.contact_dict = self.__get_Contact_dict()
        self.contact_list = []
        for _, v in enumerate(self.contact_dict.keys()):
            self.contact_list.append(v)

        # Create main window
        self.main_window = tk.Tk()
        self.main_window.title('Contact List')
        self.main_window.geometry('640x450')

        # Create frames
        self.name_frame = tk.Frame(self.main_window)
        self.number_frame = tk.Frame(self.main_window)
        self.address_frame = tk.Frame(self.main_window)
        self.city_frame = tk.Frame(self.main_window)
        self.sb_frame = tk.Frame(self.main_window)
        self.button_frame = tk.Frame(self.main_window)

        # create and pack widgets for first_name_frame
        self.name_label = tk.Label(self.name_frame, text='Name:', font=("Verdana", 15))
        self.name_val = tk.StringVar()
        self.name_ef = tk.Entry(self.name_frame, width=50, textvariable=self.name_val)
        self.name_label.pack(side='left')
        self.name_ef.pack(side='left')

        # create and pack widgets for number_frame
        self.number_label = tk.Label(self.number_frame, text='Number:', font=("Verdana", 15))
        self.number_val = tk.StringVar()
        self.number_ef = tk.Entry(self.number_frame, width=50, textvariable=self.number_val)
        self.number_label.pack(side='left')
        self.number_ef.pack(side='left')

        # create and pack widgets for address_frame
        self.address_label = tk.Label(self.address_frame, text='Address:', font=("Verdana", 15))
        self.address_val = tk.StringVar()
        self.address_ef = tk.Entry(self.address_frame, width=50, textvariable=self.address_val)
        self.address_label.pack(side='left')
        self.address_ef.pack(side='left')

        # create and pack widgets for city_frame
        self.city_label = tk.Label(self.city_frame, text='City:', font=("Verdana", 15))
        self.city_val = tk.StringVar()
        self.city_ef = tk.Entry(self.city_frame, width=40, textvariable=self.city_val)
        self.state_label = tk.Label(self.city_frame, text='State:', font=("Verdana", 15))
        self.state_val = tk.StringVar()
        self.state_ef = tk.Entry(self.city_frame, width=10, textvariable=self.state_val)
        self.city_label.pack(side="left")
        self.city_ef.pack(side="left")
        self.state_label.pack(side="left")
        self.state_ef.pack(side="left")

        # create and pack widgets for scroll_box_frame
        self.listbox = tk.Listbox(self.sb_frame, height=15, width=20,
                                  selectmode=tk.SINGLE, font=("Verdana", 12))
        for item in self.contact_list:
            self.listbox.insert(tk.END, item)
        self.listbox.bind('<<ListboxSelect>>', self.__show_Contact)
        self.sb = tk.Scrollbar(self.sb_frame, orient=tk.VERTICAL)
        self.listbox.pack(side='left')
        self.sb.pack(side='right', fill=tk.Y)

        # create and pack widgets for button_frame
        self.add_button = tk.Button(self.button_frame, width=10, text='Add',
                                    font=("Verdana", 15), command=self.__add_Contact, cursor="plus")
        self.delete_button = tk.Button(self.button_frame, width=10, text='Delete',
                                       font=("Verdana", 15), command=self.__delete_Contact)
        self.save_button = tk.Button(self.button_frame, width=10, text='Save',
                                     font=("Verdana", 15), command=self.__save_Contact)
        self.append_button = tk.Button(self.button_frame, width=10, text='Append',
                                       font=("Verdana", 15), command=self.__append_Contact)
        self.clear_button = tk.Button(self.button_frame, width=10, text='Clear',
                                      font=("Verdana", 15), command=self.__clear_ef)
        self.exit_button = tk.Button(self.button_frame, width=10, text="Exit",
                                     font=("Verdana", 15), command=self.save_and_quit)
        self.add_button.pack(side='top', padx=100)
        self.delete_button.pack(side='top', padx=100)
        self.save_button.pack(side='top', padx=100)
        self.append_button.pack(side='top', padx=100)
        self.clear_button.pack(side='top', padx=100)
        self.exit_button.pack(side='top', padx=100)

        # pack frames
        self.name_frame.pack(side='top')
        self.number_frame.pack(side='top')
        self.address_frame.pack(side='top')
        self.city_frame.pack(side='top')
        self.sb_frame.pack(side='left')
        self.button_frame.pack(side='left')

        # enter tk loop
        tk.mainloop()

    def __add_Contact(self):
        try:
            if not self.number_ef.get().isnumeric():
                raise ValueError
        except ValueError:
            mb.showerror("Error", "Please enter digits of phone number only")
            return
        try:
            if len(self.state_val.get()) != 2:
                raise ValueError
        except ValueError:
            mb.showerror("Error", "Please enter initials of state only")
            return

        new_person = Contact.Contact(self.name_ef.get(), self.number_ef.get(), self.address_ef.get(),
                                     self.city_ef.get(), self.state_ef.get())
        new_name = self.name_ef.get()
        self.contact_dict[new_name] = new_person
        self.contact_list.append(new_name)
        self.listbox.insert(tk.END, new_name)

    def __delete_Contact(self):
        # get index of selection
        index = self.listbox.curselection()
        if self.listbox.get(index[0]) in self.contact_dict:
            # remove contact from containers
            del self.contact_dict[self.listbox.get(index[0])]
            try:
                self.contact_list.remove(self.listbox.get(index[0]))
            except ValueError:
                pass
            self.listbox.delete(tk.ACTIVE)
            # clear entry fields
            self.name_val.set('')
            self.number_val.set('')
            self.address_val.set('')
            self.city_val.set('')
            self.state_val.set('')

    def __save_Contact(self):

        try:
            file_type = '*.txt'
            file_name = fd.asksaveasfilename(initialdir='/', filetypes=[("Text Files", file_type)],
                                             defaultextension=file_type, title='Select save file')
            with open(file_name, 'w') as out:
                for key in self.contact_dict:
                    out.write(f'{self.contact_dict[key].my_name}\n')
                    out.write(f'{self.contact_dict[key].number}\n')
                    out.write(f'{self.contact_dict[key].address}\n')
                    out.write(f'{self.contact_dict[key].city}\n')
                    out.write(f'{self.contact_dict[key].state}\n')
            mb.showinfo("Saved to File", "Data saved to Contacts.txt")
        except FileNotFoundError:
            mb.showerror("ERROR", "ERROR: File not found. Unable to save data")
            exit(1)

    def __append_Contact(self):
        edit_name = self.name_ef.get()
        if edit_name in self.contact_dict:
            edit_person = self.contact_dict[edit_name]
            edit_person.number = self.number_ef.get()
            edit_person.address = self.address_ef.get()
            edit_person.city = self.city_ef.get()
            edit_person.state = self.state_ef.get()

    def __clear_ef(self):
        self.name_val.set('')
        self.number_val.set('')
        self.address_val.set('')
        self.city_val.set('')
        self.state_val.set('')

    def save_and_quit(self):
        answer = mb.askyesno(title='Confirmation', message='Do you want to save before you quit?')
        if answer:
            # write to file
            try:
                file_type = '*.txt'
                file_name = fd.asksaveasfilename(initialdir='/', filetypes=[("Text Files", file_type)],
                                                 defaultextension=file_type, title='Select save file')
                with open(file_name, 'w') as outf:
                    for key in self.contact_dict:
                        outf.write(f'{self.contact_dict[key].my_name}\n')
                        outf.write(f'{self.contact_dict[key].number}\n')
                        outf.write(f'{self.contact_dict[key].address}\n')
                        outf.write(f'{self.contact_dict[key].city}\n')
                        outf.write(f'{self.contact_dict[key].state}\n')
            except FileNotFoundError:
                mb.showerror("ERROR", "ERROR: File not found. Unable to save data")
                exit(1)
            # end program
            self.main_window.destroy()
        else:
            self.main_window.destroy()

    def __show_Contact(self, event):
        selection = event.widget.curselection()
        try:
            if selection[0] >= 0:
                selection = self.listbox.get(selection)
                if selection in self.contact_dict:
                    cur_person = self.contact_dict[selection]
                    self.name_val.set(cur_person.my_name)
                    self.number_val.set(cur_person.number)
                    self.address_val.set(cur_person.address)
                    self.city_val.set(cur_person.city)
                    self.state_val.set(cur_person.state)
        # I get an index error if you select text in an entry field while an option is selected
        except IndexError:
            pass

    @staticmethod
    def __get_Contact_dict():
        # create dict
        contact_dict = {}
        try:
            # open file
            filename = "Contacts.txt"
            with open(filename, 'r') as inf:
                # assign contact_dict
                name = inf.readline().rstrip('\n')
                while name != '':
                    number = inf.readline().rstrip('\n')
                    address = inf.readline().rstrip('\n')
                    city = inf.readline().rstrip('\n')
                    state = inf.readline().rstrip('\n')
                    person = Contact.Contact(name, number, address, city, state)
                    contact_dict[person.my_name] = person
                    name = inf.readline().rstrip('\n')
        except FileNotFoundError:
            mb.showerror("ERROR", "ERROR: File not found. Unable to load contact information.")

        return contact_dict


if __name__ == '__main__':
    gui = GUI()
