export async function bejelentkezes(felhasznalonev, jelszo){
    const valasz = await fetch('/auth/bejelentkezes', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({felhasznalonev, jelszo}),
    })

    if (!valasz.ok){
        throw new Error('Hibás felhasználónév vagy jelszó!')
    }
    return valasz.text()
}

export async function helloLekeres(token){
    const valasz = await fetch('/hello/world', {
        headers: {'Authorization': 'Bearer ' + token},
    })

    if(!valasz.ok){
        throw new Error('Hiba: '+valasz.status)
    }
    return await valasz.text()
}