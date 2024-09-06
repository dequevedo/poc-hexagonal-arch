import csv
import random
from enum import Enum


class Race(Enum):
    DRAGONBORN = 'Dragonborn'
    DWARF = 'Dwarf'
    ELF = 'Elf'
    GNOME = 'Gnome'
    HALF_ELF = 'Half Elf'
    HALFLING = 'Halfling'
    HALF_ORC = 'Half Orc'
    HUMAN = 'Human'
    TIEFLING = 'Thiefling'


class Gender(Enum):
    MALE = 'Male'
    FEMALE = 'Female'


def generate_character():
    name = f"{generate_fantasy_name()}"
    age = random.randint(1, 100)
    race = random.choice(list(Race)).value
    gender = random.choice(list(Gender)).value
    return [name, age, race, gender]


def generate_fantasy_name(min_syllables=2, max_syllables=4):
    name_syllables = ["an", "ar", "el", "en", "lor", "mir", "nas", "ra", "rin", "ro", "sil", "tar", "thar", "van", "wen", "mar", "bel", "fin", "nor", "kal", "dor", "fal", "gar", "hel", "ion", "lim", "mor", "nel", "per", "quil", "rond", "seld", "tan", "var", "wol", "yel", "zor", "aes", "bryn", "drak", "fey", "glyn", "hark", "jor", "keth", "lun", "morn", "nyx", "pyr", "quen", "rath", "syn", "thorn", "urn", "vyr", "wyn"]
    surname_syllables = ["stone", "hill", "wall", "tower", "wind", "wood", "river", "fall", "field", "heart", "leaf", "vale", "forge", "glen", "hollow", "light", "mire", "oak", "peak", "quill", "ridge", "star", "thorn", "vale", "ward", "brook", "dell", "frost", "grove", "isle", "knoll", "marsh", "north", "pine", "reeds", "shade", "tor", "vine", "wold", "yew", "ash", "bramble", "crag", "fern", "heath", "loch", "meadow", "nest", "orchard", "paddock", "roost", "stream", "tarn", "wheat", "zephyr"]
    num_name_syllables = random.randint(min_syllables, max_syllables)
    num_surname_syllables = random.randint(2, 2)
    name = ''.join(random.choice(name_syllables) for _ in range(num_name_syllables))
    surname = ''.join(random.choice(surname_syllables) for _ in range(num_surname_syllables))
    return name.capitalize() + " " + surname.capitalize()


def write_characters_to_csv(filename, num_characters):
    with open(filename, mode='w', newline='', encoding='utf-8') as file:
        writer = csv.writer(file)
        writer.writerow(['Name', 'Age', 'Race', 'Gender'])

        for _ in range(num_characters):
            writer.writerow(generate_character())


num_characters = 100
filename = 'characters.csv'

write_characters_to_csv(filename, num_characters)
print(f"{num_characters} characters saved to {filename}")
