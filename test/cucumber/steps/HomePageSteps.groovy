package steps

import pages.GithubPage
import pages.HomePage
import pages.ResidueGeneratorIndexPage

import static cucumber.api.groovy.EN.*

Given(~'I am at the main page$'){ ->
    to HomePage
    at HomePage
}

When(~'I access the Residue Generator area$'){ ->
    page.selectResidueGeneratorArea()
}

Then(~'I should be at the residue generator index page$'){ ->
    at ResidueGeneratorIndexPage
}

When(~'I select the github ribbon$'){ ->
    page.selectGithubRibbon()
}

Then(~'I should be at the ResS github repository page$'){ ->
    at GithubPage
}